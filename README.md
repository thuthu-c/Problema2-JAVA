# Problema2-JAVA

II. Task Executor
a. Um executor de tarefas é composto pelos seguintes elementos:
    i. Uma Fila de Tarefas que armazena tarefas a serem processadas
    ii. Uma Fila de Resultados que armazena os resultados das tarefas processadas
    iii. Um Executor, que recupera as tarefas da fila e despacha para cada Trabalhador, que esteja livre no momento
    iv. Trabalhador, recebe a tarefa, executa a ação definida na tarefa e retorna o resultado para o Executor.

b. Uma tarefa é definida da seguinte forma:
    i. ID – Identificador único da tarefa
    ii. Custo – Custo de processamento, variando de 0 a 0.01.
    iii. Tipo – Indica se é de leitura ou de escrita
    iv. Valor – Valor que será usado como parâmetro na operação de escrita, variando de 0 a 10.

c. O resultado deve conter as seguintes informações
    i. ID – Identificador único da tarefa
    ii. Resultado – Valor após a operação de escrita ou leitura
    iii. Tempo – Tempo total desde o momento em que o Executor passou a tarefa para Trabalhador até o momento que o Trabalhador retornou o resultado

d. A execução de uma tarefa de leitura, consiste em:
    i. Aguardar o tempo relacionado ao parâmetro Custo
    ii. Ler o valor mantido em um arquivo compartilhado entre os trabalhadores
    iii. Preencher as informações do objeto Resultado e retorná-lo para o Executor
    iv. Obs. As operações de leitura podem ser realizadas de forma simultânea

e. A execução de uma tarefa de escrita, consiste em:
    i. Aguardar o tempo relacionado ao parâmetro Custo
    ii. Ler o valor mantido em um arquivo compartilhado entre os trabalhadores
    iii. Somar o valor lido do arquivo ao parâmetro informado na tarefa
    iv. Escrever o resultado da soma no arquivo
    v. Preencher as informações do objeto Resultado e retorná-lo para o Executor
    vi. Obs. As operações de escrita NÃO podem ser realizadas de forma simultânea, nem mesmo com as de leitura.

f. A implementação deve ser dividida em 2 etapas:
    i. Carregamento: Recebe um número inteiro N, um valor E (de 0 a 100) e produz uma sequência de inserções de 10N tarefas na Fila de Tarefas, seguindo as seguintes regras:
        1. ID é sequencial
        2. Custo e Valor gerados randomicamente
        3. O tipo é randomicamente definido, respeitando a restrição de que E% das tarefas devem ser de escrita, as demais serão de leitura
    ii. Processamento: Recebe um número inteiro T que representa a quantidade de threads a serem criadas como Trabalhadoras executa as tarefas e registra o tempo total gasto para o processamento de todas.

g. Execute os testes, com as seguintes variações:
    i. N = 5, 7, 9
    ii. T = 1, 16, 256
    iii. E = 0, 40

h. Para cada teste registre o tempo gasto na etapa de Processamento.
