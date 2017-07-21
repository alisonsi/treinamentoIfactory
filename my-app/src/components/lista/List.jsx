import React from 'react';
import PropTypes from 'prop-types';

const componentName = props => {
    
    const template = React.Children.only(props.children);

    return (
        <ul>
            <li>   
                { React.cloneElement( template, { item }) }
            </li>
        </ul>
        
    );
};

componentName.propTypes = {
    
};

export default componentName;