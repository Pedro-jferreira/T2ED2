Instituto Federal Goiano – Campus Urutaí
Sistemas de Informação – 4º Período
Disciplina: Estrutura de Dados 2
Prof. Junio Cesar de Lima.
Alunos: Ariana Mesquita Gonçalves e Pedro Henrique de Jesus Ferreira.

Atividade 2 – Implementação sobre Árvore Binária de Busca AVL.

Para rodar a aplicação abrir o App.java e dar play.
Ele abre direto na tela inicial da aplicação onde é possível ver à esquerda os botões de "Inserir Aluno", "Excluir Aluno",
"Pesquisar Aluno", "Listar Alunos", "Lançar Notas" e "Sair".

O passo para inserir corretamente um aluno no sistema é o seguinte:
    - acesse a tela clicando em "Inserir Aluno" na barra de navegação à esquerda;
    - coloque os dados de "matrícula" como um número inteiro;
    - coloque o nome do "Aluno" seguindo o padrão Camel-Case;
    - neste momento o aluno é criado então com notas, faltas e média zeradas - é possível conferir na aba "Listar Alunos";
    - acesse a aba "Lançar Notas" na barra de navegação à esquerda;
    - aqui é possível lançar as notas e faltas do aluno, durante as inserções o campo média não irá atualizar instantaneamente;
    - primeiro entre com a matrícula do aluno e clique em "Pesquisar", os campos serão preenchidos com os dados do aluno;
    - após ajustar as notas do aluno é só clicar em "Salvar Notas", o sistema irá confirmar caso tudo ocorra de acordo;
    - já pode conferir em "Listar Alunos".

O passo para excluir aluno no sistema é o seguinte:
    - acesse a tela clicando em "Excluir Aluno" na barra de navegação à esquerda;
    - coloque os dados de "matrícula" do aluno;
    - clique em "Pesquisar", neste momento os campos serão preenchidos com os dados do aluno para conferência;
    - sendo este o aluno para excluir, clique em "Excluir";
    - o sistema emitirá um aviso caso tudo ocorra corretamente;
    - já pode conferir em "Listar Alunos".

O passo para pesquisar um aluno é o seguinte:
    - acesse a tela clicando em "Pesquisar Aluno" na barra de navegação à esquerda;
    - coloque os dados de "matrícula" do aluno;
    - clique em "Pesquisar", neste momento os campos serão preenchidos com os dados do aluno para conferência;

O passo para listar todos os alunos existentes no sistema (impressos no método em ordem da árvore balanceada):
    - acesse a tela clicando em "Listar Alunos" na barra de navegação à esquerda;
    - a lista irá aparecer no corpo principal da aplicação.

O passo para lançar notas ou atualizar notas é o seguinte:
    - acesse a aba "Lançar Notas" na barra de navegação à esquerda;
    - aqui é possível lançar as notas e faltas do aluno, durante as inserções o campo média não irá atualizar instantaneamente;
    - primeiro entre com a matrícula do aluno e clique em "Pesquisar", os campos serão preenchidos com os dados do aluno;
    - após ajustar as notas do aluno é só clicar em "Salvar Notas", o sistema irá confirmar caso tudo ocorra de acordo;
    - já pode conferir em "Listar Alunos".

Para sair da aplicação é só clicar, a qualquer momento, o botão "Sair" na barra de navegação à esquerda.

O software sempre se inicia com 22 alunos já pré-estabelecidos e que, ao final, podem ser verificados todos os alunos inseridos ou removidos no arquivo .txt com pré-definição para o excel.

Os possíveis problemas do sistema iniciam quando são inseridos mais de 10 mil alunos na aplicação, a nível de back-end e árvore. 

O sistema foi codificado no IntelliJ e no VS Code, orientamos o uso de uma dessas IDEs, mas ele deve rodar tranquilamente em outros também. Existe uma variação a nível de telas e desempenho das mesmas quando rodar em computadores com configuração de tela superior a 1366 x 768 pixels, computadores com full HD podem apresentar variações do projeto original.


Muito Obrigada!
