197. Rising Temperature
https://leetcode.com/problems/rising-temperature/description/?envType=study-plan-v2&envId=top-sql-50

Table: Weather
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+
id is the column with unique values for this table.
There are no different rows with the same recordDate.
This table contains information about the temperature on a certain day.
 
Write a solution to find all dates id with higher temperatures compared to its previous dates (yesterday).
Return the result table in any order.
The result format is in the following example.

Example 1:
Input: 
Weather table:
+----+------------+-------------+
| id | recordDate | temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+
Output: 
+----+
| id |
+----+
| 2  |
| 4  |
+----+
Explanation: 
In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
In 2015-01-04, the temperature was higher than the previous day (20 -> 30).

solutions:=
# Write your MySQL query statement below
  
-- inner join is used to calculate within itself the table
SELECT tod.id
FROM Weather yes INNER JOIN Weather tod ON DATEDIFF(tod.recordDate,yes.recordDate) = 1  --//date diff should be 1 yesterday and today
WHERE tod.temperature > yes.temperature

       (OR)

SELECT tod.id
FROM Weather yes cross JOIN Weather tod ON DATEDIFF(tod.recordDate,yes.recordDate) = 1
WHERE tod.temperature > yes.temperature

      (OR)

SELECT tod.id
FROM Weather tod cross JOIN Weather yes ON DATEDIFF(yes.recordDate,tod.recordDate) = -1
WHERE tod.temperature > yes.temperature
