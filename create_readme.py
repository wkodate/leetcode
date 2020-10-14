import glob

files = glob.glob("./src/main/java/com/wkodate/leetcode/*")
dict = {}
for file in files:
    package = file.split("./src/main/java/com/wkodate/leetcode/")[1]
    if not package.startswith("LC"):
        continue
    num = package.split("_")[0].split("LC")[1]
    title = package.split("_", 1)[1]
    dict[int(num)] = title
sorted = sorted(dict.items(), key=lambda x:x[0])
s = "LeetCode\n===\n\n| Num | Solution |\n| -- | -- |\n"
for k, v in sorted:
    if k == 0:
        continue
    filepath = glob.glob("./src/main/java/com/wkodate/leetcode/LC" + str(k).zfill(4) + "_" + v + "/*")
    s += "| " + str(k) + " | [" + v +  "](" + filepath[0] + ") |\n"

with open('./README.md', mode='w') as f:
    f.write(s)
f.close
