import { useEffect, useState} from "react";
function TransactionList() {
    const API_URL = "personalfinancemanagerfrontend-production.up.railway.app";
    const[transactions, setTransactions] = useState([]);

    useEffect(() => {
        fetch(`${API_URL}/transactions`).then((res) =>res.json()).then((data) => setTransactions(data));
    }, []);
    return (
        <div className="bg-white rounded-2xl p-6 border border-gray-200 shadow-sm">
        <h2 className="text-xl font-bold text-gray-800 mb-6">Transactions</h2>
        {transactions.length === 0 ? (
            <p className="text-gray-400 text-center py-4">No transactions yet</p>
        ) : (
            <div className="flex flex-col gap-3">
                {transactions.reverse().map((t) => (
                    <div key={t.id} className="flex justify-between items-center bg-[#f5f5f5] rounded-xl p-4 border border-gray-200">
                        <div>
                            <p className="font-semibold text-gray-800">{t.description}</p>
                            <p className="text-gray-400 text-sm">{t.date}</p>
                        </div>
                        <div className="text-right">
                            <p className={`font-bold text-lg ${t.type === "INCOME" ? "text-green-600" : "text-red-500"}`}>
                                {t.type === "INCOME" ? "+" : "-"}£{t.amount}
                            </p>
                            <p className="text-gray-400 text-sm">{t.type}</p>
                        </div>
                    </div>
                ))}
            </div>
        )}
    </div>
    );
}
export default TransactionList;