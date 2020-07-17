package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.MenuMapper;
import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/7/14 4:27 下午
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    //@Cacheable
    public List<Menu> getAllMenusWithRoles(){
        return menuMapper.getAllMenusWithRole();
    }
}
