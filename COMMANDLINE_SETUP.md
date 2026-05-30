# 🔧 CloneMaster 命令行环境配置指南

## ✅ 环境已配置完成！

所有命令行构建环境已为您准备好！

---

## 🚀 快速开始

### 方式一: 交互式脚本 (推荐)
```bash
cd /workspace
./build_apk.sh
```

### 方式二: 直接使用 Gradle
```bash
# Debug APK
./gradlew assembleDebug

# Release APK
./gradlew assembleRelease

# 清理构建
./gradlew clean

# 查看所有任务
./gradlew tasks
```

---

## 📋 已配置的文件

| 文件 | 说明 |
|------|------|
| [gradlew](gradlew) | Gradle Wrapper 脚本 |
| [gradle/wrapper/gradle-wrapper.properties](gradle/wrapper/gradle-wrapper.properties) | Gradle 下载配置 |
| [gradle.properties](gradle.properties) | Gradle 构建优化配置 |
| [build.gradle](build.gradle) | 根项目构建配置 |
| [settings.gradle](settings.gradle) | 模块配置 |
| [build_apk.sh](build_apk.sh) | 交互式构建脚本 |
| [init_github.sh](init_github.sh) | GitHub 仓库初始化 |

---

## ⚙️ Gradle 优化配置 (gradle.properties)

已为您配置以下优化：

```properties
# 增加 JVM 堆内存到 2GB
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8

# Android X
android.useAndroidX=true
android.enableJetifier=true

# 构建优化
org.gradle.parallel=true    # 并行构建
org.gradle.caching=true     # 构建缓存
org.gradle.configuration-cache=true  # 配置缓存
```

---

## 📦 构建产物

构建成功后，APK 将生成在以下位置：

- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release APK**: `app/build/outputs/apk/release/app-release.apk`

---

## 📚 完整命令参考

### 核心构建命令
```bash
./gradlew assembleDebug          # Debug APK
./gradlew assembleRelease        # Release APK
./gradlew assembleDebug assembleRelease  # 同时构建两者
```

### 其他常用命令
```bash
./gradlew clean                  # 清理
./gradlew tasks                  # 查看所有任务
./gradlew build --dry-run        # 预演构建
./gradlew assembleDebug --stacktrace  # 详细错误日志
./gradlew help --task <taskName> # 查看任务帮助
```

### 模块相关
```bash
./gradlew :app:assembleDebug     # 只构建 app 模块
./gradlew :business_ability:build  # 只构建 business_ability
```

---

## 🔍 环境检查

运行以下命令检查环境：

```bash
cd /workspace

# 检查 Java
java -version

# 检查 Gradle Wrapper
./gradlew --version

# 查看所有可用任务
./gradlew tasks
```

---

## 📖 更多文档

- [QUICK_START.md](QUICK_START.md) - 快速构建指南
- [GITHUB_GUIDE.md](GITHUB_GUIDE.md) - GitHub 托管指南
- [README.md](README.md) - 项目说明

---

## 💡 提示

1. **首次构建**需要下载依赖，可能需要几分钟
2. 确保有良好的网络连接
3. 如果构建很慢，可以配置 Gradle 镜像源
4. 构建失败时，加上 `--stacktrace` 查看详细日志

---

## 🎉 现在开始构建吧！

最简单的方式：
```bash
cd /workspace
./build_apk.sh
```
