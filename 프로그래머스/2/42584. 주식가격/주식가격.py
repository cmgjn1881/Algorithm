def solution(prices):
    from collections import deque
    
    answer = []
    prices = deque(prices)
    
    while prices:
        now_price = prices.popleft()
        cnt = 0
        
        for price in prices:
            cnt += 1
            if price < now_price:
                break
                
        answer.append(cnt)
    
    return answer
