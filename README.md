# CloneMaster - Android App Cloner

[![Build APK](https://github.com/您的用户名/CloneMaster/actions/workflows/build.yml/badge.svg)](https://github.com/您的用户名/CloneMaster/actions/workflows/build.yml)
![Android](https://img.shields.io/badge/Android-7.0%2B-brightgreen.svg)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue.svg)
![License](https://img.shields.io/badge/license-All%20Rights%20Reserved-blue.svg)

基于**安卓分身APP全域超刚性设计规范**开发的严格二叉树架构Android应用克隆项目。

---

## 🚀 快速获取APK

### 📦 方式一: GitHub Actions 自动构建 (最推荐)

1. **Fork 本仓库** 或推送到您的 GitHub 仓库
2. 进入 **Actions** 标签页查看自动构建
3. 从构建产物直接下载 APK！

### 💻 方式二: 本地构建

#### 前置条件
- Android Studio Hedgehog | 2023.1.1+
- JDK 17+
- Android SDK API 34 (Compile)
- Min SDK: 24
- Target SDK: 34

#### 方法1: 使用 Android Studio (推荐)
1. 打开 Android Studio
2. 选择 `File` → `Open` → 选择本目录
3. 等待 Gradle 同步完成
4. 点击 `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
5. APK 生成位置: `app/build/outputs/apk/debug/app-debug.apk`

#### 方法2: 使用提供的脚本
```bash
# GitHub 方式初始化
./init_github.sh

# 本地构建
./build_apk.sh
```

#### 方法3: 命令行构建
```bash
# 进入项目目录
cd /workspace

# 首次构建需要下载依赖
chmod +x gradlew
./gradlew assembleDebug

# 生成的APK: /workspace/app/build/outputs/apk/debug/app-debug.apk
```

---

## 📦 项目架构

严格遵循**二叉树架构规范**:

```
CloneMaster (0级)
├── app (主应用模块)
├── business_ability (1级 - 业务能力)
│   ├── clone_create (2级 - 分身创建)
│   └── clone_manage (2级 - 分身管理)
└── system_kernel (1级 - 系统内核)
    ├── sandbox_isolate (2级 - 沙盒隔离)
    └── process_control (2级 - 进程控制)
```

---

## 🔑 核心特性

✅ **严格二叉树模块结构** - 所有非叶子模块严格2个子模块  
✅ **接口隔离模式** - interfaces/impl双层分离  
✅ **权限刚性封装** - 统一权限管理接口  
✅ **沙盒完全隔离** - 分身实例物理隔离  
✅ **超短方法约束** - 所有方法≤6行有效代码  
✅ **GitHub Actions CI/CD** - 自动构建和发布APK

---

## 📁 目录结构

```
/workspace/
├── app/                          # 主应用
│   ├── src/main/
│   │   ├── AndroidManifest.xml
│   │   ├── kotlin/
│   │   └── res/
├── business_ability/             # 业务能力层
│   ├── clone_create/
│   └── clone_manage/
├── system_kernel/                # 系统内核层
│   ├── sandbox_isolate/
│   └── process_control/
├── .github/workflows/            # GitHub Actions 配置
└── gradle/
```

---

## 📚 文档指南

| 文档 | 说明 |
|------|------|
| [README.md](README.md) | 项目说明 (本文件) |
| [QUICK_START.md](QUICK_START.md) | 快速构建指南 |
| [GITHUB_GUIDE.md](GITHUB_GUIDE.md) | GitHub 托管指南 |
| [build_apk.sh](build_apk.sh) | 本地构建脚本 |
| [init_github.sh](init_github.sh) | GitHub 仓库初始化脚本 |

---

## 🎯 构建产物说明

- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release APK**: `app/build/outputs/apk/release/app-release.apk`
- **Bundle**: `app/build/outputs/bundle/debug/app-debug.aab`

在 GitHub Actions 中，构建产物会自动保存 90 天！

---

## 🔒 合规声明

本项目严格遵守:
- [安卓分身APP全域超刚性设计规范](#)
- Android官方开发规范
- Material Design 3

---

## 📄 License

Copyright © 2026 CloneMaster. All rights reserved.
