@rem	-------------------------------------------------------------------------
@rem	Write by ylf 2017-09-01
@rem	-------------------------------------------------------------------------
@rem 批处理文件接口约定
@rem	%1	dist_root:		项目总根目录
@rem	%2	dist_bin:		二进制文件目录
@rem	%3	dist_lib:		库文件目录
@rem	%4	dist_etc:		系统变量uap_properties的路径=uap-application.properties配置文件的路径
@rem	-------------------------------------------------------------------------

@rem 接收参数列表
@rem	-------------------------------------------------------------------------

@set dist_root=%cd%
@set dist_bin=%dist_root%
@set dist_lib=%dist_root%\lib
@set dist_etc=file:\\\%dist_root%\config\application.properties

@rem 计算本地路径
@rem	-------------------------------------------------------------------------

@rem 运行
@rem	-------------------------------------------------------------------------
@pushd %dist_root%

@echo starting...

@start "%1" cmd /c java  -Dfile.encoding=UTF-8 -cp %dist_lib%\*;%dist_bin%\* GoldmsgApplication  %dist_etc%
@echo %1>local.pid

@echo start server success!
@popd
@rem	-------------------------------------------------------------------------