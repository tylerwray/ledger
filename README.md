## Ledger

A basic ledger application to learn java. This is a REST
API that to track transactions in a ledger.

### Endpoints

POST /api/transactions
```json
{
  "amount": 1200,
  "timestamp": "2021-08-01T00:00:00.000-06:00",
  "uid": "9e2859f9-a150-4fe3-8145-1bf6a7240219",
  "object": "transaction",
  "destination_id": "dest_123xxx",
  "source_id": "source_123xxx"
}
```

GET /api/transactions/9e2859f9-a150-4fe3-8145-1bf6a7240219
```json
{
  "amount": 1200,
  "timestamp": "2021-08-01T00:00:00.000-06:00",
  "uid": "9e2859f9-a150-4fe3-8145-1bf6a7240219",
  "object": "transaction",
  "destination_id": "dest_123xxx",
  "source_id": "source_123xxx"
}
```