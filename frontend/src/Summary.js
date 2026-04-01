import {useEffect, useState} from "react"; 

function Summary({refresh}) {
const API_URL = "https://personalfinancemanager-production-cbb6.up.railway.app";
const [summary, setSummary] = useState({
    totalIncome:0,
    totalExpense:0,
    netBalance:0
})
const token = localStorage.getItem("token");
useEffect(() =>{
    fetch(`${API_URL}/summary`, {
        headers: {
            "Authorization": `Bearer ${token}`
        }
    }).then((res) => res.json()).then((data) => setSummary(data));
}, [token, refresh]);

 return (
         <div className="bg-[#16213e] rounded-2xl p-6 border border-[#2d2d5e] shadow-xl">
        <h2 className="text-xl font-bold text-white mb-6">Summary</h2>
        <div className="grid grid-cols-3 gap-4">

            <div className="bg-[#0f3460] rounded-xl p-4 text-center border border-[#2d2d5e]">
                <p className="text-[#a0aec0] text-sm mb-1">Total Income</p>
                <p className="text-green-400 text-2xl font-bold">£{summary.totalIncome}</p>
            </div>

            <div className="bg-[#0f3460] rounded-xl p-4 text-center border border-[#2d2d5e]">
                <p className="text-[#a0aec0] text-sm mb-1">Total Expenses</p>
                <p className="text-red-400 text-2xl font-bold">£{summary.totalExpense}</p>
            </div>

            <div className="bg-[#0f3460] rounded-xl p-4 text-center border border-[#2d2d5e]">
                <p className="text-[#a0aec0] text-sm mb-1">Net Balance</p>
                <p className="text-[#7c3aed] text-2xl font-bold">£{summary.netBalance}</p>
            </div>
        </div>
    </div>
        ) 

}
export default Summary;