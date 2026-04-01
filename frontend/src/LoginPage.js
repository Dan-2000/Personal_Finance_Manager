import {useState } from "react";

function LoginPage({onLoginSuccess}) {
    const API_URL = "https://personalfinancemanager-production-cbb6.up.railway.app";

    const [isRegistering, setIsRegistering] = useState(false);
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const handleRegister = async (e) => {
        e.preventDefault();

        const response = await fetch(`${API_URL}/register`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            //role is default to USER - if an ADMIN role is needed -it will be changed by the database admin
            body: JSON.stringify({email, password, role: "USER"})
        });

        if (response.ok) {
            setIsRegistering(false);
            setError("Registration successful! Please log in.");
        }
        else {
            setError("Registration failed. Email or Password may already be in use.");
        }
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch(`${API_URL}/login`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({email, password})
        });

            if (response.ok) {
                const token = await response.text();
                localStorage.setItem("token", token);
                onLoginSuccess(token);
            }
            else {
                setError("Invalid email or password");
            }
    };

    return  (
    <div className="min-h-screen bg-[#1a1a2e] flex items-center justify-center">
        <div className="bg-[#16213e] p-8 rounded-2xl border border-[#2d2d5e] w-full max-w-sm shadow-xl">
            <h1 className="text-4xl font-bold text-white mb-2"> Finance Manager</h1>
            <p className="text-[#a0aec0] mb-8">{isRegistering ? "Create an account" : "Welcome back"}</p>
        
        <form onSubmit ={isRegistering ? handleRegister : handleSubmit} className="flex flex-col gap-4">
            <input
            type="email"
            placeholder = "Email"
            value = {email}
            onChange={(e) => setEmail(e.target.value)}
            className="bg-[#0f3460] text-white placeholder-[#a0aec0] rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]"
            />
            <input 
            type = "password"
            placeholder = "Password"
            value = {password}
            onChange ={(e) => setPassword(e.target.value)}
            className="bg-[#0f3460] text-white placeholder-[#a0aec0] rounded-xl px-4 py-3 border border-[#2d2d5e] focus:outline-none focus:border-[#7c3aed]"
            />
            <button type="submit" className="bg-[#7c3aed] hover:bg-[#6d28d9] text-white font-bold py-3 rounded-xl transition-colors duration-200">
                {isRegistering ? "Register" : "Login"}
            </button>
        </form>
        <p onClick={() => setIsRegistering(!isRegistering)}
        className="cursor-pointer text-[#a0aec0] hover:text-white mt-6 text-center text-sm transition-colors duration-200">
            {isRegistering ? "Already have an account? Login here." : "Don't have an account? Register here."}
        </p>
        {error && <p className={`text-sm mt-3 text-center ${error.includes("successful") ? "text-green-400" : "text-red-400"}`}>{error}</p>}
    </div>
    </div>
    );
}

export default LoginPage;