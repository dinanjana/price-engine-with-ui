import React from 'react';

const Item = ({ name, price = Array.from({ length: 50 }) }) => {
    return(
        <tr>
            <td>{name}</td>
            {price.map(price => (<td>{price}</td>))}
        </tr>
    );
};

const Header = () => {
  return(
      <tr>
          <th>Item</th>
          {Array.from({ length: 50 }).map((_, index) => (<th>{index + 1} unit/s</th>))}
      </tr>
  )
};

export {
    Item,
    Header,
}