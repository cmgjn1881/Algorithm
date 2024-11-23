def solution(bandage, health, attacks):
    answer = health
    cnt = 0
    for i in range(1, attacks[-1][0] + 1):
        if attacks[0][0] == i:
            damage = attacks.pop(0)
            answer -= damage[1]
            if answer <= 0:
                return -1
            else:
                cnt = 0
        else:
            cnt += 1
            answer += bandage[1]
            if cnt == bandage[0]:
                cnt = 0
                answer += bandage[2]
            if answer > health:
                answer = health
            
                
                
    return answer