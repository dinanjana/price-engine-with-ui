import React, { useState, useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { Item, Header } from './Item'
import Calculator from './Calculator';
import { getItems, getPriceForARange } from '../repository/ItemAPI';

function ItemList() {
    const [ items, setItems ] = useState(null);
    const [ prices, setPrices ] = useState(null);
    const [ showCalculator, setShowCalculator ] = useState(false);

    const handleCloseCalculator = () => setShowCalculator(false);
    const handleOpenCalculator = () => setShowCalculator(true);

    useEffect(() => {
        if (items == null) {
            getItems().then(items => setItems(items));
            console.log(items);
            return;
        }

        if (items != null && prices == null) {
            Promise.all(items.map(item => getPriceForARange(item.name, 1, 50))).then(prices => setPrices(prices));
        }
    });

    return(
        <>
            <Table responsive>
                <thead>
                    <Header/>
                </thead>
                <tbody>
                    {items != null ? items.map((item, i) => <Item name={item.name} price={prices != null ? prices[i] : undefined}/>) : ''}
                </tbody>
            </Table>
            <Button variant="primary" onClick={handleOpenCalculator}>
                Launch price calculator
            </Button>
            <Calculator
                show={showCalculator}
                handleClose={handleCloseCalculator}
                items={items}
            >
            </Calculator>
        </>
    )
}

export default ItemList;
