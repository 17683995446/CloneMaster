#!/usr/bin/env bash
# 项目环境检查脚本

echo "============================================="
echo "    CloneMaster 环境检查"
echo "============================================="
echo ""

PROJECT_DIR=$(dirname "$0")
cd "$PROJECT_DIR"

PASS=0
FAIL=0

check() {
    if $1; then
        echo "✅ $2"
        PASS=$((PASS+1))
    else
        echo "❌ $2"
        FAIL=$((FAIL+1))
    fi
}

echo "📁 检查项目文件..."
echo ""
check "[ -f gradlew ]" "Gradle Wrapper (gradlew)"
check "[ -f build.gradle ]" "根构建文件 (build.gradle)"
check "[ -f settings.gradle ]" "模块配置 (settings.gradle)"
check "[ -f gradle.properties ]" "Gradle 配置 (gradle.properties)"
check "[ -d app/ ]" "App 模块 (app/)"
check "[ -d business_ability/ ]" "业务能力模块 (business_ability/)"
check "[ -d system_kernel/ ]" "系统内核模块 (system_kernel/)"

echo ""
echo "🔍 检查执行权限..."
check "[ -x gradlew ]" "gradlew 可执行"
check "[ -x build_apk.sh ]" "build_apk.sh 可执行"

echo ""
echo "📋 检查模块结构..."
check "[ -f app/src/main/AndroidManifest.xml ]" "app Manifest"
check "[ -f business_ability/build.gradle.kts ]" "business_ability 配置"
check "[ -f system_kernel/build.gradle.kts ]" "system_kernel 配置"
check "[ -d .github/workflows/ ]" "GitHub Actions 配置"

echo ""
echo "============================================="
echo "    检查结果:"
echo "    合格: $PASS / $((PASS+FAIL))"
echo "============================================="

if [ $FAIL -eq 0 ]; then
    echo ""
    echo "🎉 所有检查通过！项目已就绪！"
    echo ""
    echo "快速开始构建:"
    echo "  ./build_apk.sh"
    echo "或:"
    echo "  ./gradlew assembleDebug"
else
    echo ""
    echo "⚠️  有 $FAIL 项未通过，请检查!"
fi
