#!/usr/bin/env bash
# CloneMaster 完整命令行构建脚本

set -e

echo "============================================="
echo "    CloneMaster - 命令行构建环境"
echo "============================================="
echo ""

PROJECT_DIR=$(dirname "$0")
cd "$PROJECT_DIR"

# 检查环境
echo "🔍 检查环境..."
echo ""

# 检查 Java
if command -v java &> /dev/null; then
    JAVA_VER=$(java -version 2>&1 | head -n 1)
    echo "✅ Java: $JAVA_VER"
else
    echo "❌ 错误: 未找到 Java!"
    echo ""
    echo "请先安装 JDK 17 或更高版本:"
    echo "  https://adoptium.net/"
    exit 1
fi

# 检查 gradlew
if [ -f "./gradlew" ]; then
    chmod +x ./gradlew
    echo "✅ Gradle Wrapper: 已就绪"
else
    echo "❌ 错误: 未找到 gradlew 脚本!"
    exit 1
fi

echo ""
echo "============================================="
echo "    请选择构建模式:"
echo "============================================="
echo "1) 构建 Debug APK (推荐)"
echo "2) 构建 Release APK"
echo "3) 同时构建 Debug 和 Release"
echo "4) 清理构建产物"
echo "5) 显示帮助信息"
read -p "请输入选项 (1-5): " choice

case $choice in
    1)
        echo ""
        echo "🚀 开始构建 Debug APK..."
        ./gradlew assembleDebug
        if [ $? -eq 0 ]; then
            echo ""
            echo "✅ Debug APK 构建成功!"
            echo "📦 输出位置: $PROJECT_DIR/app/build/outputs/apk/debug/app-debug.apk"
        else
            echo ""
            echo "❌ 构建失败!"
            exit 1
        fi
        ;;
    2)
        echo ""
        echo "🚀 开始构建 Release APK..."
        ./gradlew assembleRelease
        if [ $? -eq 0 ]; then
            echo ""
            echo "✅ Release APK 构建成功!"
            echo "📦 输出位置: $PROJECT_DIR/app/build/outputs/apk/release/app-release.apk"
        else
            echo ""
            echo "❌ 构建失败!"
            exit 1
        fi
        ;;
    3)
        echo ""
        echo "🚀 开始构建 Debug 和 Release APK..."
        ./gradlew assembleDebug assembleRelease
        if [ $? -eq 0 ]; then
            echo ""
            echo "✅ 全部构建成功!"
            echo "📦 Debug: $PROJECT_DIR/app/build/outputs/apk/debug/app-debug.apk"
            echo "📦 Release: $PROJECT_DIR/app/build/outputs/apk/release/app-release.apk"
        else
            echo ""
            echo "❌ 构建失败!"
            exit 1
        fi
        ;;
    4)
        echo ""
        echo "🧹 清理构建产物..."
        ./gradlew clean
        echo "✅ 清理完成!"
        ;;
    5)
        echo ""
        echo "============================================="
        echo "    CloneMaster 命令行帮助"
        echo "============================================="
        echo ""
        echo "常用命令:"
        echo "  ./build_apk.sh                    - 本脚本，交互式菜单"
        echo "  ./gradlew assembleDebug           - 构建 Debug APK"
        echo "  ./gradlew assembleRelease         - 构建 Release APK"
        echo "  ./gradlew clean                   - 清理构建产物"
        echo "  ./gradlew tasks                   - 查看所有可用任务"
        echo ""
        echo "构建产物位置:"
        echo "  - Debug APK: app/build/outputs/apk/debug/"
        echo "  - Release APK: app/build/outputs/apk/release/"
        echo ""
        echo "环境要求:"
        echo "  - JDK 17 或更高"
        echo "  - 网络连接 (首次需要下载依赖)"
        echo ""
        echo "其他方式:"
        echo "  - 使用 Android Studio"
        echo "  - 推送到 GitHub 后使用 GitHub Actions"
        echo ""
        echo "详细文档: QUICK_START.md"
        ;;
    *)
        echo "❌ 无效选项!"
        exit 1
        ;;
esac

echo ""
echo "============================================="
echo "    完成!"
echo "============================================="
