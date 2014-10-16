class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        l = s.strip().split()
        l.reverse()
        return ' '.join(l)

if __name__ == "__main__":
    teststrs = ('helo world', ' hel hj ')
    so = Solution()
    for test in teststrs:
        print so.reverseWords(test)

