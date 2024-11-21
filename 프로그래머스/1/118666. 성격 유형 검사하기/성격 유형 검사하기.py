def solution(survey, choices):
    answer = ''
    dict1 = {'A': 0, 'N': 0, 'C': 0, 'F': 0, 'M': 0, 'J': 0, 'R': 0, 'T': 0}

    for i in range(len(survey)):
        score = choices[i] - 4
        if score < 0:
            dict1[survey[i][0]] += abs(score)
        elif score > 0:
            dict1[survey[i][1]] += abs(score)

    answer += 'R' if dict1['R'] >= dict1['T'] else 'T'
    answer += 'C' if dict1['C'] >= dict1['F'] else 'F'
    answer += 'J' if dict1['J'] >= dict1['M'] else 'M'
    answer += 'A' if dict1['A'] >= dict1['N'] else 'N'
    
    return answer
