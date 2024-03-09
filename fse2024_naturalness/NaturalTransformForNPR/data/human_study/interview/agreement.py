from sklearn.metrics import cohen_kappa_score
import numpy as np

_MAIN_THEMES = ["Code Convention", "Code Readability", "Domain-appropriation", "Runtime resource usage"]
_SUB_THEMES = ['Context-appropriation of variable names', 'Code convention', 'Code modularity', 'Code readability', 'Code complexity', 'Code style', 'Appropriation of identifiers toward the problem/domain and code readability', 'Consistency between structure name and its content', 'Complexity of structures', 'Co-occurences of code elements', 'Naming convention', 'Meaning of variable names', 'Controlflow complexity of code', 'Consistency in term of dependency', 'Runtime resource usage', 'project-specific conventions', 'Comment style', 'Domain/paradigm-appropriation of naming and code structure', 'Method signature and docstring convention', 'Complexity of variable name']
print(len(_SUB_THEMES))
def parse_results(path):
    rs = [None] * len(_SUB_THEMES)
    with open(path, "r") as f:
        for line in f:
            sub_theme, main_theme = line.split(",")
            main_theme = main_theme.strip()
            assert main_theme in _MAIN_THEMES
            assert sub_theme in _SUB_THEMES
            sub_theme = sub_theme.strip()
            rs[_SUB_THEMES.index(sub_theme)] = _MAIN_THEMES.index(main_theme)
    
    assert None not in rs 
    return rs

a1_categories = parse_results("A1_categories.txt")
a2_categories = parse_results("A2_categories.txt")

kappa = cohen_kappa_score(a1_categories, a2_categories)

print("Cohen's Kappa:", kappa)
