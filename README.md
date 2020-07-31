# Desafio-Lis
by Willian Magnum Albeche	               
para a solção, foi usado como base a cifra de cesar, que atravez de uma chave, codifica a mensagem que vai ser enviada, e somente o possuidor da chave tem acesso a mensagem original, como o desafio em si era a descoberta da chave, o codigo se propõem a testar todas as possibilidades de chaves, até a palavra ser descoberta, descriptografar na força bruta.

Para realizar isso, foi criado um array de chars, contendo as 26 letras do alfabeto mais os 4 simbolos, cada um representado por um numero de 0 a 30, após isso,  separamos a mensagem em Chars, subistituimos os "#" por espaços e começamos a tradução.

Para se iniciar a tradução, no for mais externo no metodo translate, iremos "deslocar" a letra do alfabeto sempre um numero, no for de dentro ele vai fazer uma checagem da chave e vai formar a frase com aquela chave, e vai testando para todas as chaves.

O arquivo que vai ser lido deve ser colocado na pasta fonte do projeto, para que a leitura funcione corretamente.
Na execução ele ira pedir para digitar o nome do arquivo e o tipo dele EX: SecretMessage.txt, apos digitar, pressione enter e então espere a execução do programa que ira imprimir no terminal a solução( o codigo foi feito na IDE Intellij).
O resultado impresso é todas as tentativas de chave para a frase em questão
