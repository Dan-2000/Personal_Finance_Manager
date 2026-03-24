import {useEffect, useState} from "react"; 

function Summary() {
const API_URL = "personalfinancemanager-production-cbb6.up.railway.app";
const [summary, setSummary] = useState({
    totalIncome:0,
    totalExpense:0,
    netBalance:0
})
useEffect(() =>{
    fetch(`${API_URL}/summary`).then((res) => res.json()).then((data) => setSummary(data));
}, []);

 return (
         <div className="bg-white rounded-2xl p-6 border border-gray-200 shadow-sm">
        <h2 className="text-xl font-bold text-gray-800 mb-6">Summary</h2>
        <div className="grid grid-cols-3 gap-4">
            <div className="bg-[#f5f5f5] rounded-xl p-4 text-center border border-gray-200">
                <p className="text-gray-500 text-sm mb-1">Total Income</p>
                <p className="text-green-600 text-2xl font-bold">£{summary.totalIncome}</p>
            </div>
            <div className="bg-[#f5f5f5] rounded-xl p-4 text-center border border-gray-200">
                <p className="text-gray-500 text-sm mb-1">Total Expenses</p>
                <p className="text-red-500 text-2xl font-bold">£{summary.totalExpense}</p>
            </div>
            <div className="bg-[#f5f5f5] rounded-xl p-4 text-center border border-gray-200">
                <p className="text-gray-500 text-sm mb-1">Net Balance</p>
                <p className="text-blue-600 text-2xl font-bold">£{summary.netBalance}</p>
            </div>
        </div>
    </div>
        ) 

}
export default Summary;