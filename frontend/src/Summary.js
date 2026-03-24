import {useEffect, useState} from "react"; 

function Summary() {

const [summary, setSummary] = useState({
    totalIncome:0,
    totalExpense:0,
    netBalance:0
})
useEffect(() =>{
    fetch("https://organic-broccoli-59prrvq9pvq3v5xq-8080.app.github.dev/summary").then((res) => res.json()).then((data) => setSummary(data));
}, []);

 return (
            <div>
                <h2>Summary</h2>
                <p>Total Income: £{summary.totalIncome}</p>
                <p>Total Expenses: £{summary.totalExpense}</p>
                <p>Net Balance: £{summary.netBalance}</p>
            </div>
        ) 

}
export default Summary;