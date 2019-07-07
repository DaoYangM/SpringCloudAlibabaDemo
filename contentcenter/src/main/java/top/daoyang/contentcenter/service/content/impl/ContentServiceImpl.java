package top.daoyang.contentcenter.service.content.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.daoyang.contentcenter.dao.content.ShareMapper;
import top.daoyang.contentcenter.domain.content.DTO.ShareDTO;
import top.daoyang.contentcenter.domain.content.Share;
import top.daoyang.contentcenter.service.content.ContentService;
import top.daoyang.usercenter.domain.user.User;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContentServiceImpl implements ContentService {

    private final ShareMapper shareMapper;

    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    @Override
    public ShareDTO findShareById(Integer id) {
        Share share = shareMapper.selectByPrimaryKey(id);
        ShareDTO shareDTO = new ShareDTO();

        User user = restTemplate.getForObject(
                "http://user-center/users/{id}", User.class, share.getUserId());
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(user != null ? user.getWxNickname() : null);

        return shareDTO;
    }
}
