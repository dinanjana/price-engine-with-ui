import React, { useState, useEffect } from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { getPricePerUnit } from '../repository/ItemAPI';

const Calculator = ({ show, handleClose, items }) => {

    const [item, setItem] = useState(null);
    const [count, setCount] = useState(0);
    const [price, setPrice] = useState(0.0);

    useEffect(() => {
        if (items && !item) {
            setItem(items[0].name);
        }
    });

    const selectItem = event => {
        const { value } = event.currentTarget;
        setItem(value);
        setCount(0);
        setPrice(0.0)
    };

    const increaseCount = () => {
        const nextCount = count + 1;
        setCount(nextCount);
        getPricePerUnit(item, nextCount).then(setPrice);
    };
    const decreaseCount = () => {
        const nextCount = count -1;
        if (nextCount > -1) {
            setCount(nextCount);
            getPricePerUnit(item, nextCount).then(setPrice);
        }
    };

    return(
        <Modal
            show={show}
            onHide={handleClose}
            backdrop="static"
            keyboard={false}
        >
            <Modal.Header closeButton>
                <Modal.Title>Price Calculator</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Container>
                    <Row>
                        <Col xs={6} md={6}>
                            <Form.Group controlId="exampleForm.ControlSelect1">
                                <Form.Label>Select an item</Form.Label>
                                <Form.Control as="select" onChange={selectItem}>
                                    {items ? items.map(item => <option>{item.name}</option>): <option/>}
                                </Form.Control>
                            </Form.Group>
                        </Col>
                        <Col xs={2} md={2}>
                            <Button variant="primary" onClick={increaseCount}>
                                +
                            </Button>
                        </Col>
                        <Col xs={2} md={2}>
                            {count}
                        </Col>
                        <Col xs={2} md={2}>
                            <Button variant="secondary" onClick={decreaseCount}>
                                -
                            </Button>
                        </Col>
                    </Row>
                    <Row>
                        Price: ${price}
                    </Row>
                </Container>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="primary" onClick={handleClose}>
                    Close
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default Calculator;