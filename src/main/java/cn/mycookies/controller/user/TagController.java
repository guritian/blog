package cn.mycookies.controller.user;

import cn.mycookies.common.BaseController;
import cn.mycookies.common.ServerResponse;
import cn.mycookies.pojo.dto.TagVO;
import cn.mycookies.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @className TagController
 * @description TODO
 * @author Jann Lee
 * @date 2018-11-21 0:03
 **/
@Controller
@Api("标签/分类相关接口")
@RequestMapping("tags")
public class TagController extends BaseController {

    @Autowired
    private TagService tagService;

    @GetMapping("/{type:\\d+}")
    @ApiOperation(value = "获取标签列表", response = TagVO.class, responseContainer = "List")
    @ResponseBody
    public ServerResponse<List<TagVO>> getTagList(@PathVariable Integer type) {

        return tagService.getAllTagListInfsByType(type);
    }
}
