# Write your MySQL query statement below
SELECT firstName, lastName, (CASE WHEN city is NULL THEN null ELSE city END) AS city, (CASE WHEN state is NULL THEN null ELSE state END) AS state
FROM Person
LEFT JOIN Address
ON Person.personId = Address.personId;