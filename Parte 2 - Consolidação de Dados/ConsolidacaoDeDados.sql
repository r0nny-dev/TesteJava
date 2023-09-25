--Select que retorna o nome do departamento, quantidade de tarefas finalizadas e quantidade de tarefas não finalizadas.
SELECT
    td.titulo  AS NomeDepartamento,
    SUM(CASE WHEN tt.finalizado  = true  THEN 1 ELSE 0 END) AS TarefasFinalizadas,
    SUM(CASE WHEN tt.finalizado = false  THEN 1 ELSE 0 END) AS TarefasNaoFinalizadas
FROM
    tb_departamento td
LEFT JOIN
    tb_tarefas tt ON td.id  = tt.id_departamento 
GROUP BY
    td.titulo ;


--Select que retornar a pessoa que mais gastou horas em janeiro de 2022
SELECT
    tp.id AS ID_Pessoa,
    tp.nome AS Nome_Pessoa,
    SUM(tt.duracao) AS Total_Horas_Janeiro_2022
FROM
    tb_pessoas tp
JOIN
    tb_tarefas tt ON tp.id  = tt.id_pessoa 
WHERE
    tt.prazo >= '2022-01-01' AND tt.prazo <= '2022-01-31'
GROUP BY
    tp.id , tp.nome
ORDER BY
    Total_Horas_Janeiro_2022 DESC
LIMIT 1;

--Select que retorne título da tarefa, prazo, se tiver pessoa alocada na tarefa exibir como 
--“Encaminhado para + nome do pessoa” caso contrário “Pendente” e total de horas que essa 
--pessoa já gastou. Ordenar por prazo decrescente. 
SELECT
    tt.titulo AS Título_Tarefa,
    tt.prazo,
    CASE
        WHEN tp.nome IS NOT NULL THEN CONCAT('Encaminhado para ', tp.nome)
        ELSE 'Pendente'
    END AS Status_Pessoa,
    COALESCE(SUM(TD.duracao), 0) AS Total_Horas_Gastas
FROM
    tb_tarefas tt 
LEFT JOIN
    tb_pessoas tp ON tt.id_pessoa = tp.id 
LEFT JOIN
    tb_tarefas TD ON tt.id = TD.id 
GROUP BY
    tt.id, tt.titulo, tt.prazo, Status_Pessoa
ORDER BY
    tt.prazo DESC;
