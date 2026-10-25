# ERP para pequenas agroindústrias rurais
O sistema se propõe a substituir o controle manual em papel de uma pequena agroindústria rural por um sistema simples que automatiza pagamento de funcionários por produção, controla custos e vendas, e mostra ao dono se está tendo lucro ou prejuízo, sem exigir conhecimento técnico do usuário.

## Como executar?
1. Suba o serviço presente no `docker-compose`:
```bash
docker compose up -d
```
2. Inicie a aplicação:
```bash
./mvnw spring-boot:run
```
> Caso dê erro de permissão digite: `chmod +x mvnw`
