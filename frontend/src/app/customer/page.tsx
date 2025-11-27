'use client';

import { useState, useEffect } from 'react';
import styles from './customer.module.css';

export default function CustomerDashboard() {
    const [balance, setBalance] = useState(0);
    const [transactions, setTransactions] = useState([]);

    useEffect(() => {
        // Mock data
        setBalance(1250.50);
        setTransactions([
            { id: 1, date: '2023-11-25', description: 'Starbucks', amount: -5.50 },
            { id: 2, date: '2023-11-24', description: 'Deposit', amount: 1000.00 },
            { id: 3, date: '2023-11-23', description: 'Uber', amount: -25.00 },
        ]);
    }, []);

    return (
        <div className={styles.container}>
            <header className={styles.header}>
                <h1>My Account</h1>
                <div className={styles.balanceCard}>
                    <h2>Current Balance</h2>
                    <p className={styles.balance}>${balance.toFixed(2)}</p>
                </div>
            </header>

            <main className={styles.main}>
                <section className={styles.section}>
                    <h2>Recent Transactions</h2>
                    <ul className={styles.transactionList}>
                        {transactions.map((tx) => (
                            <li key={tx.id} className={styles.transactionItem}>
                                <div className={styles.txInfo}>
                                    <span className={styles.txDesc}>{tx.description}</span>
                                    <span className={styles.txDate}>{tx.date}</span>
                                </div>
                                <span className={`${styles.txAmount} ${tx.amount > 0 ? styles.positive : styles.negative}`}>
                                    {tx.amount > 0 ? '+' : ''}{tx.amount.toFixed(2)}
                                </span>
                            </li>
                        ))}
                    </ul>
                </section>

                <section className={styles.section}>
                    <h2>Quick Actions</h2>
                    <div className={styles.actions}>
                        <button className={styles.actionButton}>View Cards</button>
                        <button className={styles.actionButton}>Transfer Funds</button>
                        <button className={styles.actionButton}>Rewards</button>
                    </div>
                </section>
            </main>
        </div>
    );
}
