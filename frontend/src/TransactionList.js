import { useEffect, useState} from "react";
function TransactionList() {
    const API_URL = "https://personalfinancemanager-production-cbb6.up.railway.app";
    const[transactions, setTransactions] = useState([]);
    const token = localStorage.getItem("token");

    const handleDelete = async (id) => {
        const response = await fetch(`${API_URL}/transactions/${id}`, {
            method: "DELETE",
            headers: {
                "Authorization": `Bearer ${token}`
            }
        });
        if (response.ok) {        
            setTransactions(transactions.filter((t) => t.id !== id));
        }
    };

    useEffect(() => {
        fetch(`${API_URL}/transactions`, {
            headers: {
                "Authorization": `Bearer ${token}`
            }
        }).then((res) => res.json()).then((data) => setTransactions(data));
    }, [token]);
    return (
        <div className="bg-[#16213e] rounded-2xl p-6 border border-[#2d2d5e] shadow-xl">
        <h2 className="text-xl font-bold text-white mb-6">Transactions</h2>
        {transactions.length === 0 ? (
            <p className="text-[#a0aec0] text-center py-4">No transactions Found</p>
        ) : (
            <div className="flex flex-col gap-3">
                {transactions.reverse().map((t) => (
                    <div key={t.id} className="flex justify-between items-center bg-[#0f3460] rounded-xl p-4 border border-[#2d2d5e]">
                        <div>
                            <p className="font-semibold text-white">{t.description}</p>
                            <p className="text-[#a0aec0] text-sm">{t.date}</p>
                        </div>
                        <div className="text-right">
                            <p className={`font-bold text-lg ${t.type === "INCOME" ? "text-green-400" : "text-red-400"}`}>
                                {t.type === "INCOME" ? "+" : "-"}£{t.amount}
                            </p>
                            <p className="text-[#a0aec0] text-sm">{t.type}</p>
                            <button
                                onClick={() => handleDelete(t.id)}
                                className="mt-2 text-sm text-red-400 hover:text-red-600">
                                Delete
                            </button>
                        </div>
                    </div>
                ))}
            </div>
        )}
    </div>
    );
}
export default TransactionList;