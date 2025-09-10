class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s = s.rstrip() #remove the right extra spaces

        word = s.split(" ") #split the string into words

        new_words = word[-1]

        return len(new_words)

print(Solution().lengthOfLastWord("Hello World"))