import glob
import re

title_dict = {}

def convert_snake_case_to_camel_case(word):
    return ''.join(x.capitalize() or '_' for x in word.split('_'))

def gather_java_file_path():
    java_dict = {}
    java_file_root_path ="./java/src/main/java/com/wkodate/leetcode"
    java_files = glob.glob("{}/*".format(java_file_root_path))
    for file in java_files:
        package = file.split("{}/".format(java_file_root_path))[1]
        if not package.startswith("LC"):
            continue
        num = package.split("_")[0].split("LC")[1]
        title = package.split("_", 1)[1]
        title_dict[int(num)] = title
        java_filepath = glob.glob("{}/LC{}_{}/*".format(java_file_root_path, str(num).zfill(4), title))
        java_dict[int(num)] = java_filepath[0]
    return java_dict

def gather_cpp_file_path():
    cpp_dict = {}
    cpp_file_root_path ="./cpp"
    cpp_files = glob.glob("{}/*.cpp".format(cpp_file_root_path))
    for file in cpp_files:
        package = file.split("{}/".format(cpp_file_root_path))[1]
        if not package.startswith("lc"):
            continue
        num = package.split("_")[0].split("lc")[1]
        title = package.split("_", 1)[1].split(".cpp")[0]
        cpp_dict[int(num)] = file
        if num not in title_dict: 
            title = convert_snake_case_to_camel_case(title)
            title_dict[int(num)] = title
    return cpp_dict

def update_readme(java_links, cpp_links):
    s = "LeetCode\n===\n\n| Num | Problems | Java | C++ |\n| -- | -- | -- | -- |\n"
    for k, v in sorted:
        if k == 0:
            continue
        java_filepath = ""
        cpp_filepath = ""
        if k in java_links:
            java_filepath = "[solution]({})".format(java_links.get(k))
        if k in cpp_links:
            cpp_filepath = "[solution]({})".format(cpp_links.get(k))
        s += "| {} | {} | {} | {} |\n".format(str(k), v, java_filepath, cpp_filepath)
    
    with open('./README.md', mode='w') as f:
        f.write(s)
    f.close


java_links = gather_java_file_path()
cpp_links = gather_cpp_file_path()
sorted = sorted(title_dict.items(), key=lambda x:x[0])
update_readme(java_links, cpp_links)
