# LostAndFound
石大易招领轻应用

## 开发说明
1. 前端部分
  前段采用yeoman框架进行搭建，gulp作为构建工具，打包出来压缩过的html/css/js代码。
  可以通过
  ```
  python move.py
  ```
  进行快速移动前端代码至static/templates文件夹
  后端采用thyemeleaf作为模板引擎进行渲染。
2. 后端部分
  后端使用Spring-boot框架开发，连接mysql数据库，两张数据表对应两个模型，分别是石大易班官方和普通用户。两者都可以发送信息。
