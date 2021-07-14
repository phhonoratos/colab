import React from 'react';

type Props = {
    title: string
    children: React.ReactNode
}

function Card( {title, children}: Props) {
    return (
        <div className="card">
            <h5 className="card-header">{title}</h5>
            <div className="card-body">
                {children}
            </div>
        </div>
    );
}

export default Card;