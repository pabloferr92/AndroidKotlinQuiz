🧠 Quiz App – Android (Kotlin)
Este é um aplicativo de quiz educacional desenvolvido em Kotlin para Android, onde o usuário escolhe um nível de dificuldade e responde perguntas relacionadas.

📌 Funcionalidades Principais
🎯 Níveis de Dificuldade
  O app possui três níveis:
  
  Fácil
  Médio
  Difícil

  Antes de começar, o usuário deve escolher um nível. Após a escolha, somente perguntas daquele nível serão exibidas durante o quiz.

🗂️ Estrutura da Pergunta
  Cada pergunta é representada por uma estrutura contendo:
  
  texto da pergunta
  resposta correta
  nível
  (Opcional) lista de alternativas para múltipla escolha
  
  O app permite trabalhar tanto com respostas digitadas quanto com seleção de opções.

🎮 Interação do Usuário

  O usuário pode responder:
  
    Selecionando uma opção, caso múltipla escolha esteja habilitada
    
  A resposta é validada ao final do quiz.
  
  Exibe feedback informando se está correta ou incorreta nota e percetual de acertos.
  
  Após responder, o usuário pode avançar para a próxima pergunta.
  
  O usuário pode refazer o quiz, utilizando a opção de voltar no menu superior.


⭐ Funcionalidades Extras (Opcionais)

  O projeto também pode incluir melhorias adicionais:
🔀 Lógica

  Embaralhar a ordem das perguntas
  Embaralhar a ordem das opções de resposta

🎨 Visual e UX

  Cores indicando acerto ou erro
  Impedir avançar sem responder
  Permitir reiniciar o quiz

📊 Estatísticas

  Exibir porcentagem de acertos ao final do quiz


🚀 Como Executar o Projeto

Clone o repositório:
Shellgit clone https://github.com/seu-usuario/seu-repositorio.gitShow more lines

Abra no Android Studio
Aguarde a sincronização do Gradle
Execute no emulador ou dispositivo físico


📁 Estrutura Sugerida do Projeto
/
├── app/
│   ├── data/              # Modelos de dados e repositórios
│   ├── viewmodel/         # Compartilhamento de estado
│   ├── components/        # Principais componentes, botões menu de navegação
│   ├── screens/           # Telas
│   ├── navigation/        # Controle de rotas navegação e c
│   ├── ui/                # Telas do app (Compose ou Views)
│   ├── res/               # Layouts, strings, cores, temas
│   └── AndroidManifest.xml

