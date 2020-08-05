package com.goldmsg.logTool.mapper;

import com.goldmsg.logTool.entity.TbLogInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TestMapper {
    @Select("SELECT * FROM audio_tb_gmvcs_base_log_record")
    List<TbLogInfo> getLogInfos(Map map);
}
