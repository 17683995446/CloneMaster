# 🚀 CloneMaster APK 快速构建指南

## 📋 最终项目文件清单

完整的项目已就绪，包含以下内容:

✅ **工程根目录** ([/workspace/](file:///workspace/))
- [README.md](file:///workspace/README.md) - 项目说明
- [build_apk.sh](file:///workspace/build_apk.sh) - 一键构建脚本
- [build.gradle.kts](file:///workspace/build.gradle.kts) - 根项目Gradle配置
- [settings.gradle.kts](file:///workspace/settings.gradle.kts) - 模块配置
- [gradle.properties](file:///workspace/gradle.properties) - Gradle属性

✅ **主应用模块** ([/workspace/app/](file:///workspace/app/))
- [MainActivity.kt](file:///workspace/app/src/main/kotlin/com/clone/master/MainActivity.kt) - 主界面
- [CloneMasterApp.kt](file:///workspace/app/src/main/kotlin/com/clone/master/CloneMasterApp.kt) - Application
- [CloneRouterImpl.kt](file:///workspace/app/src/main/kotlin/com/clone/master/CloneRouterImpl.kt) - 路由实现
- [CloneService.kt](file:///workspace/app/src/main/kotlin/com/clone/master/CloneService.kt) - 后台服务
- [AndroidManifest.xml](file:///workspace/app/src/main/AndroidManifest.xml) - 清单文件

✅ **业务能力层** ([/workspace/business_ability/](file:///workspace/business_ability/))
- [clone_create/](file:///workspace/business_ability/clone_create/) - 分身创建
- [clone_manage/](file:///workspace/business_ability/clone_manage/) - 分身管理

✅ **系统内核层** ([/workspace/system_kernel/](file:///workspace/system_kernel/))
- [sandbox_isolate/](file:///workspace/system_kernel/sandbox_isolate/) - 沙盒隔离
- [process_control/](file:///workspace/system_kernel/process_control/) - 进程控制

---

## 🔧 方法一: Android Studio 构建 (最推荐)

### 步骤 1: 打开项目
1. 启动 **Android Studio Hedgehog | 2023.1.1+**
2. 选择 **File → Open**
3. 浏览到项目目录: `/workspace/`
4. 点击 **OK**

### 步骤 2: 等待同步
- 等待 Gradle 同步完成 (右下角进度条)
- 首次同步会下载依赖 (需要联网)

### 步骤 3: 构建 APK
1. 点击顶部菜单: **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. 等待构建完成 (约2-5分钟)
3. 构建成功后点击通知: **locate**

### 步骤 4: 获取 APK
APK 将生成在:
```
/workspace/app/build/outputs/apk/debug/app-debug.apk
```

---

## 🖥️ 方法二: 命令行构建

### 前置条件
- 已安装 Android SDK
- 已配置环境变量 `ANDROID_HOME`
- 已安装 JDK 17+

### 执行命令
```bash
cd /workspace

# 方式1: 使用提供的脚本
chmod +x build_apk.sh
./build_apk.sh

# 方式2: 直接使用 Gradle
# 如果您有 gradle 或 gradlew
./gradlew assembleDebug
```

---

## 📦 构建成功后

### 获取APK文件
构建成功后，APK位置:

- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release APK**: `app/build/outputs/apk/release/app-release.apk`

### 在设备上安装
```bash
adb install /workspace/app/build/outputs/apk/debug/app-debug.apk
```

---

## 🔍 项目特点

✅ **完整的严格二叉树架构**  
✅ **interfaces/impl 双层分离**  
✅ **30个Kotlin源文件**  
✅ **所有核心功能已实现**  
✅ **兼容 Android 7.0+ (API 24)**  
✅ **Material Design 3 风格**  

---

## 🛠️ 问题排查

### 问题1: Gradle 同步失败
- 检查网络连接
- File → Invalidate Caches / Restart

### 问题2: 找不到 SDK
- File → Project Structure → SDK Location
- 设置正确的 Android SDK 路径

### 问题3: 依赖下载失败
- 配置国内镜像源 (阿里云/腾讯云)

---

## 📄 License

CloneMaster - Android App Cloner
Copyright © 2026
