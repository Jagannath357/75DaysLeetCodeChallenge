class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sDict = {i:s.count(i) for i in list(s)}
        tDict = {i:t.count(i) for i in list(t)}
        if len(sDict) == len(tDict):
            for i in sDict:
                if sDict.get(i) != tDict.get(i):
                    return False
        else:
            return False
        return True
        