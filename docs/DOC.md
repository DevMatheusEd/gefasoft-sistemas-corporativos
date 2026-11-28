<a id="topo"></a>

# Sistema de Gestão de Micro Agroindústria

Cada história está associada a um relacionamento do diagrama ER.

![Diagrama Entidade Relacionamento](diagrama/diagrama.png)

> O sistema é **multi-tenant**: cada proprietário configura suas próprias funções, produtos e insumos. Por isso, as histórias são escritas de forma genérica. Os casos concretos estão na seção [Exemplos](#exemplos), no final do documento, e cada história que tem exemplo traz um link **ver exemplo**.

**Personas**
- **Proprietário**: dono da micro agroindústria, quem usa o sistema.
- **Funcionário**: trabalhador pago por diária, que exerce uma função na produção. Não acessa o sistema.

---

## 1. PROPRIETARIO → MICRO_AGROINDUSTRIA (possui)

**Cardinalidade:** um proprietário possui uma ou mais agroindústrias.

- <a id="us01"></a>**US01** Como **proprietário**, quero cadastrar minha agroindústria, para que meus dados fiquem organizados dentro do sistema.
- <a id="us02"></a>**US02** Como **proprietário**, quero cadastrar mais de uma agroindústria na mesma conta, para gerenciar todos os meus negócios em um só lugar.
- <a id="us03"></a>**US03** Como **proprietário**, quero ver apenas os dados das minhas agroindústrias, para que ninguém além de mim acesse minhas informações.

**Critérios de aceite**
- Toda agroindústria pertence a exatamente um proprietário.
- Um proprietário só visualiza e edita as agroindústrias que são dele.

---

## 2. MICRO_AGROINDUSTRIA → FUNCIONARIO (possui)

**Cardinalidade:** uma agroindústria possui um ou mais funcionários.

- <a id="us04"></a>**US04** Como **proprietário**, quero cadastrar funcionários na minha agroindústria, para poder registrar o trabalho e os pagamentos deles.
- <a id="us05"></a>**US05** Como **proprietário**, quero listar todos os funcionários de uma agroindústria, para saber quem trabalha comigo.
- <a id="us06"></a>**US06** Como **proprietário**, quero editar ou desativar um funcionário, para manter o cadastro atualizado quando alguém sair, sem perder o histórico de diárias.

**Critérios de aceite**
- Todo funcionário pertence a uma única agroindústria.
- Funcionários desativados continuam aparecendo nos registros antigos.

---

## 3. FUNCAO → FUNCIONARIO (possui)

**Cardinalidade:** uma função é exercida por vários funcionários; cada funcionário tem uma função.

- <a id="us07"></a>**US07** Como **proprietário**, quero cadastrar as funções exercidas na minha agroindústria, para classificar o trabalho de cada pessoa. [ver exemplo](#ex-01)
- <a id="us08"></a>**US08** Como **proprietário**, quero associar uma função a cada funcionário, para saber o que cada um faz na produção. [ver exemplo](#ex-01)
- <a id="us09"></a>**US09** Como **proprietário**, quero filtrar funcionários por função, para ver rapidamente todos que exercem uma determinada atividade. [ver exemplo](#ex-01)

**Critérios de aceite**
- Não é possível cadastrar um funcionário sem função.
- Não é possível excluir uma função que ainda tenha funcionários associados.

---

## 4. FUNCIONARIO → DIARIA_PRODUCAO (realiza)

**Cardinalidade:** um funcionário realiza várias diárias; cada diária é de um único funcionário.

- <a id="us10"></a>**US10** Como **proprietário**, quero registrar a diária de um funcionário em uma data, informando o valor, para controlar quanto devo a ele.
- <a id="us11"></a>**US11** Como **proprietário**, quero ver o histórico de diárias de um funcionário, para conferir o que ele trabalhou em um período.
- <a id="us12"></a>**US12** Como **proprietário**, quero ver o total de diárias ainda não pagas de cada funcionário, para saber quanto devo a ele hoje.
- <a id="us13"></a>**US13** Como **proprietário**, quero editar uma diária que ainda não foi paga, para corrigir erros de digitação.

**Critérios de aceite**
- Toda diária tem funcionário, data e valor.
- Diárias já vinculadas a um pagamento não podem ser editadas nem excluídas.

---

## 5. PAGAMENTO → DIARIA_PRODUCAO (reúne)

**Cardinalidade:** um pagamento reúne várias diárias; uma diária pertence a no máximo um pagamento (fica sem pagamento até ser paga).

- <a id="us14"></a>**US14** Como **proprietário**, quero gerar um pagamento somando as diárias pendentes de um funcionário, para pagá-lo sem precisar calcular manualmente.
- <a id="us15"></a>**US15** Como **proprietário**, quero ver quais diárias compõem cada pagamento, para conferir ou explicar o valor pago.
- <a id="us16"></a>**US16** Como **proprietário**, quero que as diárias já pagas sejam marcadas como quitadas, para não pagar a mesma diária duas vezes.
- <a id="us17"></a>**US17** Como **proprietário**, quero consultar o histórico de pagamentos, para ter controle financeiro da agroindústria.

**Critérios de aceite**
- O valor total do pagamento é a soma do valor das diárias vinculadas.
- Uma diária só pode ser vinculada a um pagamento.
- Diárias já vinculadas não aparecem como pendentes.

---

## 6. UNIDADE_MEDIDA → PRODUTO (tem)

**Cardinalidade:** uma unidade de medida pode ser usada em vários produtos; cada produto tem uma unidade.

- <a id="us18"></a>**US18** Como **proprietário**, quero cadastrar os produtos que minha agroindústria fabrica, com sua unidade de medida, para registrar a produção com a medida certa. [ver exemplo](#ex-02)
- <a id="us19"></a>**US19** Como **proprietário**, quero informar o tipo de embalagem do produto, para diferenciar o mesmo produto vendido em embalagens distintas. [ver exemplo](#ex-02)

**Critérios de aceite**
- Todo produto precisa ter uma unidade de medida (KG, G, UN ou METRO).

---

## 7. UNIDADE_MEDIDA → INSUMO (tem)

**Cardinalidade:** uma unidade de medida pode ser usada em vários insumos; cada insumo tem uma unidade.

- <a id="us20"></a>**US20** Como **proprietário**, quero cadastrar os insumos que minha agroindústria usa, com sua unidade de medida, para registrar o consumo corretamente. [ver exemplo](#ex-03)
- <a id="us21"></a>**US21** Como **proprietário**, quero informar o preço unitário do insumo, para estimar o custo da produção.

**Critérios de aceite**
- Todo insumo precisa ter uma unidade de medida.

---

## 8. DIARIA_PRODUCAO → PRODUCAO_PRODUTO (gera)

**Cardinalidade:** uma diária pode gerar zero ou mais produções; cada registro de produção pertence a uma diária.

- <a id="us22"></a>**US22** Como **proprietário**, quero registrar o que o funcionário produziu na diária (produto e quantidade), para saber a produção de cada dia. [ver exemplo](#ex-04)
- <a id="us23"></a>**US23** Como **proprietário**, quero registrar mais de um produto na mesma diária, para o caso de o funcionário produzir itens diferentes no mesmo dia. [ver exemplo](#ex-04)
- <a id="us24"></a>**US24** Como **proprietário**, quero registrar uma diária sem nenhuma produção, para não ser obrigado a informar produto em funções cujo trabalho não gera um produto final. [ver exemplo](#ex-05)

**Critérios de aceite**
- A produção é opcional.
- Cada registro de produção informa produto e quantidade.

---

## 9. PRODUTO → PRODUCAO_PRODUTO (produzido)

**Cardinalidade:** um produto pode aparecer em várias produções; cada registro de produção refere-se a um único produto.

- <a id="us25"></a>**US25** Como **proprietário**, quero ver o total produzido de cada produto em um período, para acompanhar o rendimento da agroindústria.
- <a id="us26"></a>**US26** Como **proprietário**, quero ver quais funcionários produziram determinado produto, para saber quem contribuiu em cada produção.

---

## 10. DIARIA_PRODUCAO → CONSUMO_INSUMO (consome)

**Cardinalidade:** uma diária pode consumir zero ou mais insumos; cada registro de consumo pertence a uma diária.

- <a id="us27"></a>**US27** Como **proprietário**, quero registrar o insumo consumido na diária, com a quantidade, para saber quanta matéria-prima foi usada por dia. [ver exemplo](#ex-06)
- <a id="us28"></a>**US28** Como **proprietário**, quero registrar o consumo de um insumo sem informar a quantidade, para registrar que foi usado mesmo quando não é medido. [ver exemplo](#ex-07)
- <a id="us29"></a>**US29** Como **proprietário**, quero registrar uma diária sem consumo de insumo, para o caso em que o funcionário não consumiu matéria-prima registrada.

**Critérios de aceite**
- O consumo é opcional.
- A quantidade pode ficar em branco.

---

## 11. INSUMO → CONSUMO_INSUMO (consumido)

**Cardinalidade:** um insumo pode aparecer em vários consumos; cada registro de consumo refere-se a um único insumo.

- <a id="us30"></a>**US30** Como **proprietário**, quero ver o total consumido de cada insumo em um período, para controlar o uso de matéria-prima. [ver exemplo](#ex-08)
- <a id="us31"></a>**US31** Como **proprietário**, quero comparar o consumo de insumo com a produção gerada, para avaliar o rendimento do processo. [ver exemplo](#ex-08)

---

## Melhorias futuras (fora do escopo desta entrega)

- **Preço por função com sugestão de valor:** o sistema calcularia `quantidade × preço da função` e avisaria o proprietário caso o valor digitado fosse diferente, sem bloquear. Exigiria uma tabela `PRECO_FUNCAO` e os campos `valorSugerido`, `valorAjustado` e `justificativa` na diária.
- **Rastreabilidade de produtos intermediários:** permitir que o resultado de uma etapa (ex.: matéria-prima já beneficiada) seja registrado como produto intermediário, ligando o trabalho de uma função ao da etapa seguinte.
- **Despesas:** preencher a entidade `DESPESA` para controlar custos como insumos auxiliares e embalagem.

---

<a id="exemplos"></a>

## Exemplos

Todos os exemplos abaixo são de uma **casa de farinha** (processamento de mandioca). Outro proprietário poderia cadastrar funções, produtos e insumos completamente diferentes, sem alterar nenhuma história acima.

### <a id="ex-01"></a>E01. Funções e funcionários

- Funções cadastradas: **Raspador**, **Gomeiro**, **Forneiro**.
- João é associado à função Raspador; Theo, à função Gomeiro; Zé, à função Forneiro.
- Ao filtrar por "Raspador", o sistema lista todos os raspadores (no caso, João).

↩ Voltar: [US07](#us07) · [US08](#us08) · [US09](#us09) · [Topo](#topo)

### <a id="ex-02"></a>E02. Produtos, unidade de medida e embalagem

| Produto | Unidade de medida | Tipo de embalagem |
|---|---|---|
| Goma | KG | A granel |
| Farinha | UN | Saco |

O mesmo produto poderia ter embalagens diferentes, por exemplo farinha em saco ou farinha a granel.

↩ Voltar: [US18](#us18) · [US19](#us19) · [Topo](#topo)

### <a id="ex-03"></a>E03. Insumos e unidade de medida

| Insumo | Unidade de medida |
|---|---|
| Mandioca | KG |
| Lenha | METRO |

↩ Voltar: [US20](#us20) · [Topo](#topo)

### <a id="ex-04"></a>E04. Diária com produção

Theo (gomeiro) pegou a mandioca já raspada e produziu **500 kg de goma**.

| Diária | Consumo de insumo | Produção |
|---|---|---|
| Theo, 1 diária | nenhum | Goma, 500 kg |

Se, no mesmo dia, Theo também tivesse produzido outro item, bastaria adicionar mais um registro de produção na mesma diária.

↩ Voltar: [US22](#us22) · [US23](#us23) · [Topo](#topo)

### <a id="ex-05"></a>E05. Diária sem produção

João (raspador) trabalhou o dia inteiro raspando, mas seu trabalho não gera um produto final. A diária dele é registrada **sem nenhum registro de produção**.

↩ Voltar: [US24](#us24) · [Topo](#topo)

### <a id="ex-06"></a>E06. Diária com consumo de insumo

João (raspador) raspou mandioca em dois dias:

| Data | Insumo | Quantidade |
|---|---|---|
| 12/10 | Mandioca | 1000 kg |
| 13/10 | Mandioca | 700 kg |

↩ Voltar: [US27](#us27) · [Topo](#topo)

### <a id="ex-07"></a>E07. Consumo sem quantidade

Zé (forneiro) usou lenha para produzir farinha, mas a lenha não é medida:

| Diária | Consumo de insumo | Produção |
|---|---|---|
| Zé, 1 diária | Lenha, **quantidade em branco** | Farinha, 2 sacos |

↩ Voltar: [US28](#us28) · [Topo](#topo)

### <a id="ex-08"></a>E08. Totais e rendimento

- **Total consumido:** somando as diárias do período, o sistema mostra quantos kg de mandioca foram consumidos.
- **Rendimento:** comparando o consumo de mandioca com a goma produzida, o proprietário vê quantos kg de mandioca foram necessários para cada kg de goma.

↩ Voltar: [US30](#us30) · [US31](#us31) · [Topo](#topo)