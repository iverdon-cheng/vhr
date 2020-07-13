package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/7/11 5:22 下午
 */
public interface HrMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Hr record);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);

    Integer updatePasswd(@Param("hrid") Integer hrid, @Param("encodePass") String encodePass);

    Integer updateUserface(@Param("url") String url, @Param("id") Integer id);


}
