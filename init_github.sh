#!/usr/bin/env bash
# CloneMaster GitHub 仓库初始化脚本

set -e

echo "============================================="
echo "    CloneMaster - GitHub 仓库初始化"
echo "============================================="
echo ""

PROJECT_DIR=$(dirname "$0")
cd "$PROJECT_DIR"

# 检查 Git 是否已初始化
if [ -d ".git" ]; then
    echo "✅ Git 仓库已初始化"
else
    echo "📦 正在初始化 Git 仓库..."
    git init
    git branch -M main
    echo "✅ Git 仓库初始化成功"
fi

echo ""
echo "📝 添加文件到暂存区..."
git add .

echo ""
echo "🔖 请输入提交信息 (默认: Initial commit): "
read -r commit_msg

if [ -z "$commit_msg" ]; then
    commit_msg="Initial commit: CloneMaster Android App Cloner"
fi

echo ""
echo "💾 正在提交..."
git commit -m "$commit_msg" || true

echo ""
echo "============================================="
echo "    仓库初始化成功!"
echo "============================================="
echo ""
echo "接下来，请在 GitHub 上创建仓库，然后执行:"
echo ""
echo "git remote add origin https://github.com/您的用户名/仓库名.git"
echo "git push -u origin main"
echo ""
echo "或者，如果您想自动配置，请提供您的仓库地址:"
read -p "请输入仓库 URL (留空跳过): " repo_url

if [ -n "$repo_url" ]; then
    git remote add origin "$repo_url"
    echo "✅ 远程仓库已设置"
    echo ""
    echo "执行推送..."
    git push -u origin main
fi

echo ""
echo "============================================="
echo "    完成! 下一步操作:"
echo "============================================="
echo ""
echo "1. 访问您的 GitHub 仓库"
echo "2. 进入 Actions 标签页查看自动构建"
echo "3. 从构建产物下载 APK!"
echo ""
echo "查看详细指南: GITHUB_GUIDE.md"
echo ""
