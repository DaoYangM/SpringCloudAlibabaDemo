package top.daoyang.contentcenter.controller.content;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.daoyang.contentcenter.domain.content.DTO.ShareDTO;
import top.daoyang.contentcenter.service.content.ContentService;

@RestController
@RequestMapping("/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/{id}")
    public ShareDTO getShareById(@PathVariable Integer id) {
        return contentService.findShareById(id);
    }
}
