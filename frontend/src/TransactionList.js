import { useEffect, useState} from "react";
function TransactionList() {
    const[transactions, setTransactions] = useState([]);

    useEffect(() => {
        fetch("https://organic-broccoli-59prrvq9pvq3v5xq-8080.app.github.dev/transactions").then((res) =>res.json()).then((data) => setTransactions(data));
    }, []);
    return (
        <div>
            <h2>Transactions</h2>
            {transactions.map((t) => (
                <div key={t.id}>
                <p>{t.date} - {t.description} - £{t.amount} - {t.type}</p>
                </div>
            ))}
        </div>
    );
}
export default TransactionList;