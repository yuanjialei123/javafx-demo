
```
--------------
    -- main
        -- java
            -- fx                                   存放javafx页面对应的java文件
                -- controller                       页面对应的Controller
                -- AbstractFxApplication            页面加载类
            -- service                              业务代码
            -- util                                 工具类
            -- JavafxDemoApplication                启动类
        -- resource
            -- fxml                                 页面布局代码
                -- datasource.fxml                  需要选择数据库的页面
                -- seleect-file.fxml                需要选择文件的页面
            -- style                                css样式
                -- style.css                        通用样式代码
```


### 打包

1. meven窗口>插件>jfx>jfx:native
2. 进入target>jfx>app 双击 jar 运行
3. 可以将整个App目录打包

## 注意 
##### AbstractFxApplication.java 类中有两个方法 再Start中调用

> fileSelectPageShow();    调出文件选择页面

> dataSourcePageShow();    调出数据库配置页面
 

## Controller
```java

```
