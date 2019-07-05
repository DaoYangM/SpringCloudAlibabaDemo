package top.daoyang.contentcenter.service.content;

import top.daoyang.contentcenter.domain.content.DTO.ShareDTO;

public interface ContentService {

    ShareDTO findShareById(Integer id);
}
