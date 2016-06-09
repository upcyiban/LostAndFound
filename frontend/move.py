#-*- coding:utf-8 -*-
import os
import os.path
import shutil
distpath = "dist"
resourcespath = "../src/main/resources"
staticpath = resourcespath + "/static"
tempaltespath = resourcespath + "/templates"

#清理resources目录
if os.path.isdir(staticpath):
    shutil.rmtree(staticpath) #删除static目录
    print "static 删除成功"
if os.path.isdir(tempaltespath):
    shutil.rmtree(tempaltespath) #删除tempaltes目录
    print "templates 删除成功"

#移动到 static 目录
if os.path.isdir(distpath + "/fonts"):
    shutil.copytree(distpath + "/fonts",staticpath + "/fonts")
    print "fonts 移动成功"
if os.path.isdir(distpath + "/images"):
    shutil.copytree(distpath + "/images",staticpath + "/images")
    print "images 移动成功"
if os.path.isdir(distpath + "/scripts"):
    shutil.copytree(distpath + "/scripts",staticpath + "/scripts")
    print "scripts 移动成功"
if os.path.isdir(distpath + "/styles"):
    shutil.copytree(distpath + "/styles",staticpath + "/styles")
    print "styles 移动成功"

# 移动到templates目录
os.mkdir(tempaltespath)
for parent,dirnames,filenames in os.walk(distpath):
    for filename in filenames:
        if(parent == "dist"):
            shutil.copyfile(distpath + "/" +filename,tempaltespath + "/" + filename)
            print filename + " 移动成功"
