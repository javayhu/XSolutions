# Definition for a point
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

class Solution:
    # @param points, a list of Points
    # @return an integer
    def maxPoints(self, points):
        lines={}
        if points==[]: return 0
        if len(points)==1: return 1
        maxPoints=2 #init points 2
        for i in range(len(points)):
            countlist={}
            duplicate=0

            #point i and point j form a line!
            for j in range(i+1,len(points)):
                if i==j: continue
                if points[i].x==points[j].x and points[i].y==points[j].y:
                    duplicate+=1 #duplicate point! not count here!
                    continue
                deltax=points[j].x-points[i].x
                deltay=points[j].y-points[i].y
                if (deltax==0): #vertical line, use x to be the key!
                    key=(deltax)
                else:
                    key=float(deltay)/deltax
                if key not in countlist.keys():
                    countlist[key]=2 # not exist this line, so add 2
                else: countlist[key]+=1 #line exists, so add only 1

            #if point i is in that final line, what's its max points?
            if countlist.values() !=[]:
                #add duplicate here!
                maxPoints=max(maxPoints,max(countlist.values())+duplicate)
            else: #if countlist.values() ==[] that is to say all points are duplicated!
                return max(maxPoints,duplicate+1)

        return maxPoints

if __name__=='__main__':
    # [(3,10),(0,2),(0,2),(3,10)]
    points=[Point(3,10),Point(0,2),Point(0,2),Point(3,10)]
    print(Solution().maxPoints(points))