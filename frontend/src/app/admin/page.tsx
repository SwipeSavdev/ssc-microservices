'use client';

import { useState, useEffect } from 'react';
import Link from 'next/link';
import styles from './admin.module.css';

export default function AdminDashboard() {
    const [tenants, setTenants] = useState([]);

    useEffect(() => {
        // TODO: Fetch from API
        // fetch(`${process.env.NEXT_PUBLIC_API_URL}/tenants`)
        //   .then(res => res.json())
        //   .then(data => setTenants(data));

        // Mock data
        setTenants([
            { id: 1, name: 'Acme Corp', email: 'admin@acme.com', status: 'ACTIVE' },
            { id: 2, name: 'Globex', email: 'contact@globex.com', status: 'PENDING' },
        ]);
    }, []);

    return (
        <div className={styles.container}>
            <header className={styles.header}>
                <h1>Admin Dashboard</h1>
                <Link href="/admin/create-tenant" className={styles.button}>
                    Add Tenant
                </Link>
            </header>

            <main className={styles.main}>
                <table className={styles.table}>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {tenants.map((tenant) => (
                            <tr key={tenant.id}>
                                <td>{tenant.id}</td>
                                <td>{tenant.name}</td>
                                <td>{tenant.email}</td>
                                <td>
                                    <span className={`${styles.status} ${styles[tenant.status.toLowerCase()]}`}>
                                        {tenant.status}
                                    </span>
                                </td>
                                <td>
                                    <button className={styles.actionButton}>View</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </main>
        </div>
    );
}
