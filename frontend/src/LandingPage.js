import { useEffect, useRef, useState } from "react";
import LoginPage from "./LoginPage";

function LandingPage({ onLoginSuccess }) {
    const loginRef = useRef(null);
    const [heroOpacity, setHeroOpacity] = useState(1);

    const scrollToLogin = () => {
        loginRef.current.scrollIntoView({ behavior: "smooth" });
    };

    useEffect(() => {
    const handleScroll = () => {
        const scrollY = window.scrollY;
        const opacity = Math.max(0, 1 - scrollY / 400);
        setHeroOpacity(opacity);
    };
    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
}, []);

useEffect(() => {
    const observer = new IntersectionObserver(
        (entries) => {
            entries.forEach((entry) => {
                if (entry.isIntersecting) {
                    entry.target.classList.add("opacity-100", "translate-y-0");
                    entry.target.classList.remove("opacity-0", "translate-y-8");
                }
            });
        },
        { threshold: 0.1 }
    );
    document.querySelectorAll(".fade-in").forEach((el) => observer.observe(el));
    return () => observer.disconnect();
}, []);

    return (
    <div className="bg-[#1a1a2e] min-h-screen">

        {/* Navbar */}
        <nav className="fixed top-0 left-0 right-0 z-50 flex justify-between items-center px-8 py-4 bg-[#1a1a2e] border-b border-[#2d2d5e]">
            <h1 className="text-xl font-bold text-white"> Finance Manager</h1>
            <button
                onClick={scrollToLogin}
                className="bg-[#7c3aed] hover:bg-[#6d28d9] text-white font-bold px-6 py-2 rounded-xl transition-colors duration-200">
                Login / Register
            </button>
        </nav>

        {/* Hero */}
        <div style={{ opacity: heroOpacity }} className="flex flex-col items-center justify-center text-center px-8 pt-40 pb-16 transition-opacity">
            <h2 className="text-6xl font-bold text-white mb-6">Take control of your finances</h2>
            <p className="text-[#a0aec0] text-xl max-w-xl mb-10">Track income and expenses, view your balance at a glance and manage your money — all in one place.</p>
            <button
                onClick={scrollToLogin}
                className="bg-[#7c3aed] hover:bg-[#6d28d9] text-white font-bold px-8 py-4 rounded-xl text-lg transition-colors duration-200">
                Get Started
            </button>
        </div>

        <div className="fade-in opacity-0 translate-y-8 transition-all duration-700 max-w-5xl mx-auto px-8 py-8">
    <h3 className="text-3xl font-bold text-white text-center mb-8">Everything you need</h3>
    <div className="grid grid-cols-3 gap-8">
        <div className="bg-[#16213e] rounded-2xl p-6 border border-[#2d2d5e]">
            <div className="text-4xl mb-4">
                <img src={require("./assets/track-transactions.jpg")} alt="Track" className="w-16 h-16 mb-4"/>
            </div>
            <h4 className="text-xl font-bold text-white mb-3">Track Transactions</h4>
            <p className="text-[#a0aec0]">Add income and expenses with a date, description and amount. See your full transaction history at a glance.</p>
        </div>
        <div className="bg-[#16213e] rounded-2xl p-6 border border-[#2d2d5e]">
            <div className="text-4xl mb-4">
                <img src={require("./assets/live-summary.jpg")} alt="Summary" className="w-16 h-16 mb-4"/>
            </div>
            <h4 className="text-xl font-bold text-white mb-3">Live Summary</h4>
            <p className="text-[#a0aec0]">See your total income, total expenses and net balance update in real time as you add transactions.</p>
        </div>
        <div className="bg-[#16213e] rounded-2xl p-6 border border-[#2d2d5e]">
            <div className="text-4xl mb-4">
                <img src={require("./assets/secure-private.jpg")} alt="Secure" className="w-16 h-16 mb-4"/>
            </div>
            <h4 className="text-xl font-bold text-white mb-3">Secure & Private</h4>
            <p className="text-[#a0aec0]">Your data is protected with JWT authentication. Only you can see your transactions.</p>
        </div>
    </div>
</div>

{/* Images of website working */}
<div className="fade-in opacity-0 translate-y-8 transition-all duration-700 max-w-5xl mx-auto px-8 py-8">
    <h3 className="text-3xl font-bold text-white text-center mb-8">See it in action</h3>
    <div className="grid grid-cols-2 gap-8">
        <div className="bg-[#16213e] rounded-2xl p-4 border border-[#2d2d5e]">
            <img src={require("./assets/Summary.png")} alt="Summary" className="rounded-xl w-full"/>
            <p className="text-[#a0aec0] text-center mt-4">Live financial summary</p>
        </div>
        <div className="bg-[#16213e] rounded-2xl p-4 border border-[#2d2d5e]">
            <img src={require("./assets/Transaction History.png")} alt="Transactions" className="rounded-xl w-full"/>
            <p className="text-[#a0aec0] text-center mt-4">Full transaction history</p>
        </div>
        <div className="bg-[#16213e] rounded-2xl p-4 border border-[#2d2d5e]">
            <img src={require("./assets/Add Transaction.png")} alt="Add Transaction" className="rounded-xl w-full"/>
            <p className="text-[#a0aec0] text-center mt-4">Add transactions easily</p>
        </div>
        <div className="bg-[#16213e] rounded-2xl p-4 border border-[#2d2d5e]">
            <img src={require("./assets/Edit Transaction.png")} alt="Edit Transaction" className="rounded-xl w-full"/>
            <p className="text-[#a0aec0] text-center mt-4">Edit transactions with ease</p>
        </div>
    </div>
</div>

{/* Login section */}
<div ref={loginRef} className="fade-in opacity-0 translate-y-8 transition-all duration-700 py-8">
    <LoginPage onLoginSuccess={onLoginSuccess} />
        </div>
    </div>
);
}

export default LandingPage;