import glob

# Java
java_files = glob.glob("./src/main/java/com/wkodate/leetcode/*")
java_dict = {}
for file in java_files:
    package = file.split("./src/main/java/com/wkodate/leetcode/")[1]
    if not package.startswith("LC"):
        continue
    num = package.split("_")[0].split("LC")[1]
    title = package.split("_", 1)[1]
    java_dict[int(num)] = title

# C++
cpp_files = glob.glob("./cpp/*.cpp")
cpp_dict = {}
for file in cpp_files:
    package = file.split("./cpp/")[1]
    if not package.startswith("lc"):
        continue
    num = package.split("_")[0].split("lc")[1]
    cpp_dict[int(num)] = file

sorted = sorted(java_dict.items(), key=lambda x:x[0])
s = "LeetCode\n===\n\n| Num | Problems | Java | C++ |\n| -- | -- | -- | -- |\n"
for k, v in sorted:
    if k == 0:
        continue
    java_filepath = glob.glob("./src/main/java/com/wkodate/leetcode/LC" + str(k).zfill(4) + "_" + v + "/*")
    cpp_filepath = ""
    if k in cpp_dict:
        cpp_filepath = "[solution]({})".format(cpp_dict.get(k))
    s += "| {} | {} | [solution]({}) | {} | \n".format(str(k), v, java_filepath[0], cpp_filepath)

with open('./README.md', mode='w') as f:
    f.write(s)
f.close
