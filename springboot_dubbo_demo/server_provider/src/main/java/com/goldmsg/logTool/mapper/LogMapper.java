package com.goldmsg.logTool.mapper;

import com.goldmsg.logTool.entity.TbLogInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Create with Intellij IDEA
 * Created by : ylf
 * Time :2018/03/31 18:02
 * Description :
 */
@Mapper
@Component
public interface LogMapper {
    //获取
    List<TbLogInfo> getInfos(Map map);

}
